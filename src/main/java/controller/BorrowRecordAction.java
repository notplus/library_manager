package controller;

import java.util.List;

import dao.BorrowRecordDao;
import model.BorrowRecord;

public class BorrowRecordAction {
    @SuppressWarnings("rawtypes")
    public Object[][] setQueryTable(String[] columnNames) throws Exception {
        BorrowRecordDao borrowRecordDao = new BorrowRecordDao();
        List list = borrowRecordDao.query();
        Object[][] results = new Object[list.size()][columnNames.length];

        for (int i = 0; i < list.size(); i++) {
            BorrowRecord borrowRecord = (BorrowRecord) list.get(i);

            results[i][0] = borrowRecord.getID();
            results[i][1] = borrowRecord.getUser_id();
            results[i][2] = borrowRecord.getBook_id();
            results[i][3] = borrowRecord.getBook_name();
            results[i][4] = borrowRecord.getBorrow_date();
            results[i][5] = borrowRecord.getBorrow_time();
            results[i][6] = borrowRecord.getDue_date();
        }

        return results;
    }

    public List<Integer> getChartData() throws Exception {
        BorrowRecordDao borrowRecordDao=new BorrowRecordDao();
        
        return borrowRecordDao.getChartData();

    }
}
