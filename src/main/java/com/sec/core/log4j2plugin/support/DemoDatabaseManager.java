package com.sec.core.log4j2plugin.support;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.db.AbstractDatabaseManager;
import org.apache.logging.log4j.core.util.Closer;
import org.apache.logging.log4j.nosql.appender.NoSqlConnection;
import org.apache.logging.log4j.nosql.appender.NoSqlObject;
import org.apache.logging.log4j.nosql.appender.NoSqlProvider;

/**
 * ClassName: DemoDatabaseManager
 * Description: //TODO
 * Created by feifei.liu on 2017/6/12 19:25
 **/
public class DemoDatabaseManager<W> extends AbstractDatabaseManager {
    protected static final DemoDatabaseManager.MongoDatabaseManagerFactory FACTORY = new DemoDatabaseManager.MongoDatabaseManagerFactory();
    protected final NoSqlProvider<NoSqlConnection<W, ? extends NoSqlObject<W>>> provider;
    protected NoSqlConnection<W, ? extends NoSqlObject<W>> connection;

    protected DemoDatabaseManager(String name, int bufferSize, NoSqlProvider<NoSqlConnection<W, ? extends NoSqlObject<W>>> provider) {
        super(name, bufferSize);
        this.provider = provider;
    }

    protected void startupInternal() {
    }

    protected boolean shutdownInternal() {
        return Closer.closeSilently(this.connection);
    }

    protected void connectAndStart() {
        try {
            this.connection = this.provider.getConnection();
        } catch (Exception var2) {
            throw new AppenderLoggingException("Failed to get connection from NoSQL connection provider.", var2);
        }
    }

    protected void writeInternal(LogEvent event) {
        if(this.isRunning() && this.connection != null && !this.connection.isClosed()) {
            NoSqlObject<W> entity = this.connection.createObject();
//            entity.set("level", event.getLevel());
//            entity.set("loggerName", event.getLoggerName());
//            entity.set("message", event.getMessage() == null?null:event.getMessage().getFormattedMessage());
//            StackTraceElement source = event.getSource();
//            if(source == null) {
//                entity.set("source", (Object)null);
//            } else {
//                entity.set("source", this.convertStackTraceElement(source));
//            }
//
//            Marker marker = event.getMarker();
//            if(marker == null) {
//                entity.set("marker", (Object)null);
//            } else {
//                entity.set("marker", this.buildMarkerEntity(marker));
//            }
//
//            entity.set("threadId", Long.valueOf(event.getThreadId()));
//            entity.set("threadName", event.getThreadName());
//            entity.set("threadPriority", Integer.valueOf(event.getThreadPriority()));
//            entity.set("millis", Long.valueOf(event.getTimeMillis()));
//            entity.set("date", new Date(event.getTimeMillis()));
//            Throwable thrown = event.getThrown();
//            NoSqlObject contextMapEntity;
//            if(thrown == null) {
//                entity.set("thrown", (Object)null);
//            } else {
//                NoSqlObject<W> originalExceptionEntity = this.connection.createObject();
//                contextMapEntity = originalExceptionEntity;
//                originalExceptionEntity.set("type", thrown.getClass().getName());
//                originalExceptionEntity.set("message", thrown.getMessage());
//                originalExceptionEntity.set("stackTrace", this.convertStackTrace(thrown.getStackTrace()));
//
//                while(thrown.getCause() != null) {
//                    thrown = thrown.getCause();
//                    NoSqlObject<W> causingExceptionEntity = this.connection.createObject();
//                    causingExceptionEntity.set("type", thrown.getClass().getName());
//                    causingExceptionEntity.set("message", thrown.getMessage());
//                    causingExceptionEntity.set("stackTrace", this.convertStackTrace(thrown.getStackTrace()));
//                    contextMapEntity.set("cause", causingExceptionEntity);
//                    contextMapEntity = causingExceptionEntity;
//                }
//
//                entity.set("thrown", originalExceptionEntity);
//            }
//
//            Map<String, String> contextMap = event.getContextMap();
//            if(contextMap == null) {
//                entity.set("contextMap", (Object)null);
//            } else {
//                contextMapEntity = this.connection.createObject();
//                Iterator i$ = contextMap.entrySet().iterator();
//
//                while(i$.hasNext()) {
//                    Map.Entry<String, String> entry = (Map.Entry)i$.next();
//                    contextMapEntity.set((String)entry.getKey(), entry.getValue());
//                }
//
//                entity.set("contextMap", contextMapEntity);
//            }
//
//            ThreadContext.ContextStack contextStack = event.getContextStack();
//            if(contextStack == null) {
//                entity.set("contextStack", (Object)null);
//            } else {
//                entity.set("contextStack", contextStack.asList().toArray());
//            }
            entity.set("name", "feifei.liu");
            this.connection.insertObject(entity);
        } else {
            throw new AppenderLoggingException("Cannot write logging event; NoSQL manager not connected to the database.");
        }
    }

    protected NoSqlObject<W> buildMarkerEntity(Marker marker) {
        NoSqlObject<W> entity = this.connection.createObject();
        entity.set("name", marker.getName());
        Marker[] parents = marker.getParents();
        if(parents != null) {
            NoSqlObject<W>[] parentEntities = new NoSqlObject[parents.length];

            for(int i = 0; i < parents.length; ++i) {
                parentEntities[i] = this.buildMarkerEntity(parents[i]);
            }

            entity.set("parents", parentEntities);
        }

        return entity;
    }

    protected boolean commitAndClose() {
        return true;
    }

    protected NoSqlObject<W>[] convertStackTrace(StackTraceElement[] stackTrace) {
        NoSqlObject<W>[] stackTraceEntities = this.connection.createList(stackTrace.length);

        for(int i = 0; i < stackTrace.length; ++i) {
            stackTraceEntities[i] = this.convertStackTraceElement(stackTrace[i]);
        }

        return stackTraceEntities;
    }

    protected NoSqlObject<W> convertStackTraceElement(StackTraceElement element) {
        NoSqlObject<W> elementEntity = this.connection.createObject();
        elementEntity.set("className", element.getClassName());
        elementEntity.set("methodName", element.getMethodName());
        elementEntity.set("fileName", element.getFileName());
        elementEntity.set("lineNumber", Integer.valueOf(element.getLineNumber()));
        return elementEntity;
    }

    public static DemoDatabaseManager<?> getMongoDatabaseManager(String name, int bufferSize, NoSqlProvider<?> provider) {
        return AbstractDatabaseManager.getManager(name, new DemoDatabaseManager.FactoryData(bufferSize, provider), FACTORY);
    }

    protected static final class MongoDatabaseManagerFactory implements ManagerFactory<DemoDatabaseManager<?>, FactoryData> {
        private MongoDatabaseManagerFactory() {
        }

        public DemoDatabaseManager<?> createManager(String name, DemoDatabaseManager.FactoryData data) {
            return new DemoDatabaseManager(name, data.getBufferSize(), data.provider);
        }
    }

    protected static final class FactoryData extends AbstractFactoryData {
        private final NoSqlProvider<?> provider;

        protected FactoryData(int bufferSize, NoSqlProvider<?> provider) {
            super(bufferSize);
            this.provider = provider;
        }
    }
}
