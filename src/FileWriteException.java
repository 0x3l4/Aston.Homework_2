import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class FileWriteException extends IOException {
    private final AtomicReference<String> fileName = new AtomicReference<String>();

    public FileWriteException(String message, String fileName) {
        super(message);
        this.fileName.set(fileName);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " " + fileName;
    }

    public String getFileName() {
        return fileName.get();
    }
}
