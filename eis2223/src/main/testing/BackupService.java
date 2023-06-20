package it.unipd.dei.eis.testing;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BackupService {

    private Duration backupTime = Duration.ofSeconds(5);

    public BackupService(){
    }

    void setBackupTime(long seconds){
        this.backupTime = Duration.ofSeconds(seconds);
    }

    public void doBackup() throws InterruptedException {

        TimeUnit.SECONDS.sleep(backupTime.getSeconds());

    }

}
