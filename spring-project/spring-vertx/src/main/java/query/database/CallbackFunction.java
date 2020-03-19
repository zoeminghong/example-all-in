package query.database;

import com.ecfront.dew.common.Resp;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
@FunctionalInterface
public interface CallbackFunction<T> {
    void result(Resp<T> result);
}
