import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class FileReadException extends IOException {
    private final AtomicReference<String> fileName = new AtomicReference<String>();

    public FileReadException(String message, String fileName) {
        super(message);
        this.fileName.set(fileName);
    }

    public String getFileName() {
        return fileName.get();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " " + fileName;
    }
}
