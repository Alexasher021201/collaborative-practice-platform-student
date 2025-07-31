package team8.ad.project.result;


import lombok.Data;

import java.util.List;

@Data
public class QsResult<T> {
    private List<T> items;
    private int totalCount;
    private int page;
    private int pageSize;
    private boolean success = true;
    private String errorMessage;
}