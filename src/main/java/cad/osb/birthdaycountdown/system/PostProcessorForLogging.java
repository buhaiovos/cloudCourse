package cad.osb.birthdaycountdown.system;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessorForLogging implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        LogManager.getLogger(PostProcessorForLogging.class)
                .info("PPAI - " + o.getClass().toString());
        return o;
    }
}
