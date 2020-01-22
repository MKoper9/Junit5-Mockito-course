package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecitionOrderTest {
@Test
    void callingBAckupWithoutCreatingAFileFirstShouldThrowException(){
//given
    OrderBackup orderBackup = new OrderBackup();

    //then
    assertThrows(IOException.class,() -> orderBackup.backupOrder(new Order()));
}
}
