package pl.devfoundry.testing;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeAfterExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext){
        System.out.println("Inside before each extension");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext){
        System.out.println("Inside after each extension");
    }
}
