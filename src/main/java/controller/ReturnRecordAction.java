package controller;

import java.util.List;

import dao.ReturnRecordDao;
import model.ReturnRecord;

public class ReturnRecordAction {
    @SuppressWarnings("rawtypes")
    public Object[][] setQueryTable(String[] columnNames) throws Exception {
        ReturnRecordDao returnRecordDao = new ReturnRecordDao();
        List list = returnRecordDao.query();
        Object[][] results = new Object[list.size()][columnNames.length];

        for (int i = 0; i < list.size(); i++) {
            ReturnRecord returnRecord = (ReturnRecord) list.get(i);

            results[i][0] = returnRecord.getID();
            results[i][1] = returnRecord.getUser_id();
            results[i][2] = returnRecord.getBook_id();
            results[i][3] = returnRecord.getBook_name();
            results[i][4] = returnRecord.getBorrow_date();
            results[i][5] = returnRecord.getBorrow_time();
            results[i][6] = returnRecord.getReturn_date();
            results[i][7] = returnRecord.getReturn_time();
        }

        return results;
    }
}