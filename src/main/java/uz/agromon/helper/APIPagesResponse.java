package uz.agromon.helper;

public class APIPagesResponse extends APIResponse {
    private long totalCount;
    private int currentPage;


    public APIPagesResponse(long totalCount, int currentPage) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
