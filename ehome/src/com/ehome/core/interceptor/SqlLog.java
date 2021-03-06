package com.ehome.core.interceptor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;

public class SqlLog implements ISqlLog, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private JdbcTemplate jdbcTemplate;

    private ExecutorService service = Executors.newCachedThreadPool();

    private final static String SQL_TMP = "INSERT INTO T_SQL_LOG (`cost_time`, `sql_id`, `sql`) VALUES (%s, %s, %s)";

    private volatile static AtomicInteger atomic = new AtomicInteger(0);

    private BlockingQueue<String> sqlList = new LinkedBlockingQueue<String>(10);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SqlLog.applicationContext = applicationContext;
    }

    private void clear() {
        atomic = new AtomicInteger(0);
        sqlList.clear();
    }

    @Override
    public void save(long cost, String sql_id, String sql) {

        //TODO: use with redis lpush
        final String exeSql = StringEscapeUtils
                .escapeSql(String.format(SQL_TMP, cost, "\"" + sql_id + "\"", "\"" + sql.replace("\"", "\\\"") + "\""));

        if (null == jdbcTemplate) {
            jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        }

        try {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    // FIXME 暂时屏蔽
//                    jdbcTemplate.execute(exeSql);
                }
            });
        } catch (Exception e) {
            System.err.println(exeSql);
        }

    }

}
