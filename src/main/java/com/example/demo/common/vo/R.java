package com.example.demo.common.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 返回数据
 *
 * @author admin

 * @date 2016年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        r.put("RespMessage", msg);
        return r;
    }
    /**
     * 返回list 结果集的时候 返回的结果集合节点为result
     * @param list
     * @return
     */
    public static R ok(List<?> list){
        return R.ok().put("result", list);
    }


    public static R ok(JSONObject resJs){
        R r = ok();
        r.putAll(resJs);
        return r;
    }
    /**是否成功 RespCode == 10000 时成功，返回true**/
    public boolean isSuccess() {
        Object code = get("RespCode");
        if(code == null) {
            return false;
        }
        return "10000".equals(code.toString());
    }

    public boolean isFail() {
        return !isSuccess();
    }
    public String getString(String key) {
        Object obj = get(key);
        if(obj == null) {
            return null;
        }else {
            return obj.toString();
        }
    }
    /**
     * 返回list 结果集的时候 返回的结果集合节点为result
     * @param set
     * @return
     */
    public static R ok(Set<?> set){
        return R.ok().put("result", set);
    }
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R putAllObj(JSONObject obj) {
        super.putAll(obj);
        return this;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public R put(Integer length, Object result) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("result", result);
        dataMap.put("length", length);
        super.put("data", dataMap);
        return this;
    }

    public static R error(int code, Throwable e) {
        R r = new R();
        r.put("code", code);
        String msg = "";
        if(null != e && null != e.getMessage()) {
            String exMsg = e.getMessage();
            if(!StringUtils.isEmpty(exMsg)) {
                if(exMsg.length() > 50 ) {
                    exMsg = exMsg.substring(0, 49);
                }
                msg = "("+exMsg+")";
            }
        }
        r.put("msg", "系统发生异常，请联系管理员."+msg);
        return r;
    }
    public static R error(Throwable e) {
        return error(500, e);
    }


    @Override
    public String toString() {
        JSONObject json = (JSONObject) JSON.toJSON(this);
        return json.toJSONString();
    }
}
