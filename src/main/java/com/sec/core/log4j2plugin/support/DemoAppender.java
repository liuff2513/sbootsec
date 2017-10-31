package com.sec.core.log4j2plugin.support;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.util.Booleans;
import org.apache.logging.log4j.nosql.appender.NoSqlProvider;

/**
 * ClassName: DemoAppender
 * Description: //TODO
 * Created by feifei.liu on 2017/6/12 14:46
 **/
@Plugin(name = "Demo", category = "Core", elementType = "log4j2plugin", printObject = true)
public class DemoAppender extends AbstractDatabaseAppender<DemoDatabaseManager<?>> {
    private final String description = this.getName() + "{ manager=" + this.getManager() + " }";

    protected DemoAppender(String name, Filter filter, boolean ignoreExceptions, DemoDatabaseManager manager) {
        super(name, filter, ignoreExceptions, manager);
    }

    public String toString() {
        return this.description;
    }

    @PluginFactory
    public static DemoAppender createAppender(@PluginAttribute("name") String name,
                                              @PluginAttribute("ignoreExceptions") String ignore,
                                              @PluginElement("Filter") Filter filter,
                                              @PluginAttribute("bufferSize") String bufferSize,
                                              @PluginElement("NoSqlProvider") NoSqlProvider<?> provider) {
        if(provider == null) {
            LOGGER.error("NoSQL provider not specified for appender [{}].", name);
            return null;
        } else {
            int bufferSizeInt = AbstractAppender.parseInt(bufferSize, 0);
            boolean ignoreExceptions = Booleans.parseBoolean(ignore, true);
            String managerName = "noSqlManager{ description=" + name + ", bufferSize=" + bufferSizeInt + ", provider=" + provider + " }";
            DemoDatabaseManager<?> manager = DemoDatabaseManager.getMongoDatabaseManager(managerName, bufferSizeInt, provider);
            return manager == null?null:new DemoAppender(name, filter, ignoreExceptions, manager);
        }
    }


}
