package god.batch.b.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.example.bat.domain.trade.CustomerCredit;

@Repository
public class BatchBDAO extends EgovComAbstractDAO {

    public List<Integer> getAllCustomerCreditIds(CustomerCredit customerCredit) {
        return selectList("getAllCustomerCreditIds", customerCredit);
    }

}
