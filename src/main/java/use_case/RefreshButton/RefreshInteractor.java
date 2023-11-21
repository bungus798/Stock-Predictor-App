package use_case.RefreshButton;
import java.time.LocalDateTime;
public class RefreshInteractor {

    final RefreshDataAccessInterface refreshDataAccessObject;
    final RefreshOutputBoundary refreshOutputBoundary;

    public RefreshInteractor(RefreshDataAccessInterface refreshDataAccessInterface, RefreshOutputBoundary refreshOutputBoundary) {
        this.refreshDataAccessObject = refreshDataAccessInterface;
        this.refreshOutputBoundary = refreshOutputBoundary;
    }
    public void execute() {
        refreshDataAccessObject.refresh();
        LocalDateTime now = LocalDateTime.now();
        RefreshOutputData refreshOutputData = new RefreshOutputData(now.toString());
        refreshOutputBoundary.prepareSuccessView(refreshOutputData);
    }
}
