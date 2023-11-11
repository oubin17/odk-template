package com.odk.odktemplateapi.api;

import com.odk.base.dto.request.BaseRequest;
import com.odk.base.dto.response.BaseResponse;
import com.odk.base.dto.response.ServiceResponse;
import com.odk.base.exception.AssertUtil;
import com.odk.base.exception.BizErrorCode;
import com.odk.base.exception.BizException;
import com.odk.odktemplateutil.constext.ServiceContextHolder;
import com.odk.odktemplateutil.enums.BizScene;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * AbstractApiImpl
 *
 * @description:
 * @version: 1.0
 * @author: oubin on 2023/11/11
 */
public class AbstractApiImpl extends AbstractApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractApiImpl.class);

    /**
     * summary log
     */
    private static final String SEP = ",";

    private static final String NULL_REPLACE = "-";

    protected <T, R> ServiceResponse<R> bizProcess(BizScene bizScene, BaseRequest request, Class<R> resultClazz, ApiCallBack<T, R> callBack) {
        long startTime = System.currentTimeMillis();
        ServiceResponse<R> response = null;
        try {
            //1. 初始化上下文
            initContext(bizScene);
            //2.简单参数校验
            AssertUtil.notNull(request, BizErrorCode.PARAM_ILLEGAL, "request is null.");
            //3.参数校验
            callBack.checkParams(request);
            //4.执行业务逻辑前置操作，如参数转换，复杂参数检查
            callBack.beforeProcess(request);
            //5.对象转换：request -> dto
            Object args = callBack.convert(request);
            ServiceResponse<T> apiResponse = callBack.doProcess(args);
            //6.出参转换：dto -> response
            response = callBack.assembleResult(apiResponse, resultClazz);
        } catch (BizException exception) {
            response = handleBizException(exception);
        } catch (Throwable t) {
            response = handleSystemException(t);
        } finally {
            long executeTime = System.currentTimeMillis() - startTime;
            callBack.afterProcess(response);
            if (null != response) {
                LOGGER.info(buildDigestLog(bizScene, response.isSuccess(), response.getErrorCode(), executeTime, ServiceContextHolder.getLoginId()));
            }
            clearContext();
        }
        return response;
    }


    public abstract static class ApiCallBack<T, R> {

        /**
         * 基本参数校验
         *
         * @param request
         */
        protected void checkParams(BaseRequest request) {

        }

        /**
         * 处理请求的前置操作，比如数据模型转换等。
         *
         * @param request
         */
        protected void beforeProcess(BaseRequest request) {

        }

        /**
         * 参数转换：request -> dto
         *
         * @param request
         * @return
         */
        protected Object convert(BaseRequest request) {
            return new Object();
        }

        /**
         * 核心业务处理
         *
         * @param args
         * @return
         */
        protected abstract ServiceResponse<T> doProcess(Object args);

        /**
         * 将服务层返回的对象转成controller层返回的对象
         *
         * @param apiResult
         * @param resultClazz
         * @return
         * @throws Throwable
         */
        protected ServiceResponse<R> assembleResult(ServiceResponse<T> apiResult, Class<R> resultClazz) throws Throwable {
            R response = resultClazz.newInstance();
            ServiceResponse<R> serviceResponse = ServiceResponse.valueOf(apiResult);
            serviceResponse.setData(response);
            return serviceResponse;
        }

        /**
         * post-execution process 后置处理
         *
         * @param response
         */
        protected void afterProcess(BaseResponse response) {
        }
    }

    /**
     * 初始化请求上下文信息
     *
     * @param bizScene
     */
    private static void initContext(BizScene bizScene) {
        ServiceContextHolder.setSceneCode(bizScene);
    }

    /**
     * 清除上下文
     */
    private static void clearContext() {
        ServiceContextHolder.clear();
    }

    /**
     * 业务异常处理模板
     *
     * @param bizEx
     * @return
     */
    private ServiceResponse handleBizException(BizException bizEx) {
        LOGGER.error("biz exception occurred，error code: {}，error message: {}", bizEx.getErrorCode(), bizEx.getMessage());

        return generateBaseResult(bizEx);
    }


    /**
     * 异常信息统一处理方法
     *
     * @param throwable
     * @return
     */
    private ServiceResponse generateBaseResult(Throwable throwable) {
        BizErrorCode errorCode;
        String errorMsg = null;
        if (throwable instanceof BizException) {
            BizException exception = (BizException) throwable;
            errorCode = exception.getErrorCode();
            if (errorCode == BizErrorCode.PARAM_ILLEGAL) {
                errorMsg = throwable.getMessage();
            }
        } else {
            errorCode = BizErrorCode.SYSTEM_ERROR;
        }

        try {
            return ServiceResponse.valueOfError(
                    Objects.requireNonNull(errorCode).getErrorType(),
                    Objects.requireNonNull(errorCode).getCode(),
                    errorMsg == null ? errorCode.getErrorContext() : errorMsg);
        } catch (Throwable t) {
            LOGGER.error("new system exception occurred, error message: {}", t.getMessage());
            return null;
        }
    }

    /**
     * 系统异常处理模板
     *
     * @param e
     * @return
     */
    private ServiceResponse handleSystemException(Throwable e) {
        LOGGER.error("unknown exception occurred, error message: {}", e.getMessage());
        return generateBaseResult(e);
    }

    /**
     * 当前请求汇总日志
     *
     * @param isSuccess
     * @param resultCode
     * @param executeTime
     * @param loginId
     * @return
     */
    private String buildDigestLog(BizScene bizScene, boolean isSuccess, String resultCode, long executeTime, String loginId) {
        try {
            return "[" + bizScene.getCode() + SEP +
                    StringUtils.defaultIfBlank(loginId, NULL_REPLACE) + SEP +
                    isSuccess + SEP +
                    StringUtils.defaultIfBlank(resultCode, NULL_REPLACE) + "]" +
                    "(" + executeTime + "ms)";
        } catch (Throwable e) {
            LOGGER.error("exception occur when constructing log information.");
            return "";
        }
    }
}
