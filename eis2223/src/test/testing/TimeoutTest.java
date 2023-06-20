package it.unipd.dei.eis.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofSeconds;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeoutTest {

    BackupService backupService = new BackupService();

    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(1), () -> backupService.doBackup());
    }

    @Test
    void timeoutExceeded() {
        // rimuovere il commento da una delle due righe precedenti
//        assertTimeout(ofSeconds(1), () -> backupService.doBackup());
//        assertTimeoutPreemptively(ofSeconds(1), () -> backupService.doBackup());
    }

}
