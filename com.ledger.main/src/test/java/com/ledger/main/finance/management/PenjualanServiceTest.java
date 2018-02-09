package com.ledger.main.finance.management;

import com.ledger.common.application.finance.management.PenjualanService;
import com.ledger.common.dto.finance.management.PenjualanDTO;
import com.ledger.domain.financial.management.PenjualanRepository;
import java.util.List;
import static org.activiti.engine.impl.scripting.JuelScriptEngine.print;
import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author 3AD
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/ledger-context-application.xml",
    "classpath:/ledger-context-infrastructure.xml"
})
public class PenjualanServiceTest {

    @Autowired
    private PenjualanRepository penjualanRepository;

    @Autowired
    private PenjualanService penjualanService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(penjualanRepository);
        /* Header*/
        print("Data EventAgit Processing");

        /* Incident Record*/
        PenjualanDTO m = penjualanService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        penjualanService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        PenjualanDTO b = penjualanService.findByID(m.getPenjualanID());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<PenjualanDTO> listEventAgit = (List<PenjualanDTO>) penjualanService.findAll();
        for (PenjualanDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
