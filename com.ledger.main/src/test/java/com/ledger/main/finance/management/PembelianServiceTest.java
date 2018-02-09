package com.ledger.main.finance.management;

import com.ledger.common.application.finance.management.PembelianService;
import com.ledger.common.dto.finance.management.PembelianDTO;
import com.ledger.domain.financial.management.PembelianRepository;
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
public class PembelianServiceTest {

    @Autowired
    private PembelianRepository pembelianRepository;

    @Autowired
    private PembelianService pembelianService;

    @Test
    public void testEnd2EndEvent() {
        Validate.notNull(pembelianRepository);
        /* Header*/
        print("Data EventAgit Processing");

        /* Incident Record*/
        PembelianDTO m = pembelianService.getDummyData();

        System.out.println("Incident Record : " + m.toString());

        pembelianService.SaveOrUpdate(m);
        System.out.println("Incident Record has been saved succesfully");

        System.out.println("");
        System.out.println("Find by ID");
        PembelianDTO b = pembelianService.findByID(m.getPembelianID());
        System.out.println("EventAgit :" + b.toString());

        System.out.println("");
        System.out.println("Find ALL");
        List<PembelianDTO> listEventAgit = (List<PembelianDTO>) pembelianService.findAll();
        for (PembelianDTO bt : listEventAgit) {
            System.out.println("Event :" + bt.toString());

        }

    }

    public void printThisMessage(String msg) {

        System.out.println("------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------");

    }
}
