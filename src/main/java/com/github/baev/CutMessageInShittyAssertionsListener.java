package com.github.baev;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.TestCaseResult;

import javax.xml.bind.JAXB;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 13.04.15
 */
public class CutMessageInShittyAssertionsListener extends RunListener {

    @Override
    public void testFailure(Failure failure) throws Exception {
        Allure.LIFECYCLE.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult testCaseResult) {
                JAXB.marshal(testCaseResult, System.out);

                if (testCaseResult.getFailure() == null) {
                    return;
                }

                String message = testCaseResult.getFailure().getMessage();

                if (message == null) {
                    return;
                }

                if (message.length() > 100) {
                    String firstPart = message.substring(0, 100);
                    testCaseResult.getFailure().setMessage(firstPart);
                }
            }
        });
    }

    @Override
    public void testFinished(Description description) throws Exception {

    }
}
