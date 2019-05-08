package dev.charlesferreira.upcomingmoviesapi.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryString {

    private Map<String, Object> params;

    private QueryString(Map<String, Object> params) {
        this.params = params;
    }

    public static QueryString newInstance() {
        return new QueryString(new HashMap<>());
    }

    public static QueryString fromParams(Map<String, Object> params) {
        return new QueryString(params);
    }

    public void set(String key, String value) {
        params.put(key, value);
    }

    public String getQuery() {
        return params.entrySet()
                .stream()
                .map(QueryString::join)
                .collect(Collectors.joining("&"));
    }

    @Override
    public String toString() {
        return getQuery();
    }

    private static String join(Map.Entry entry) {
        return String.format("%s=%s", entry.getKey(), entry.getValue());
    }

}
