package io.jeongjm.rest.mariadb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@PropertySources({
    @PropertySource( value = "file:F:/work/project/boot/config.properties", ignoreResourceNotFound = true ),
})
@Repository
public class dao {
    @Autowired
    JdbcTemplate jt;

    public List<Map<String, ?>> selectAll() {

        return jt.query("SELECT * FROM fmk_member", (rs, rowNum) -> {
            Map<String, Object> mss = new HashMap<>();
            mss.put("idx", rs.getInt(1));
            mss.put("mobile", rs.getString(5));
            mss.put("name", rs.getString(10));
            mss.put("email", rs.getString(4));
            return mss;
        });
    }

    public List<Map<String, ?>> select() {

        return jt.query("SELECT * FROM fmk_member", (rs, rowNum) -> {
            Map<String, Object> mss = new HashMap<>();
            mss.put("idx", rs.getInt(1));
            mss.put("mobile", rs.getString(5));
            mss.put("name", rs.getString(10));
            mss.put("email", rs.getString(4));
            return mss;
        });
    }
}
