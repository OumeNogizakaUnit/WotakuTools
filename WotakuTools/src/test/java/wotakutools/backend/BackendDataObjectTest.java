package wotakutools.backend;

import org.junit.Test;
import static org.junit.Assert.*;

import wotakutools.backend.BackendDataObject;

import java.time.LocalDateTime;

public class BackendDataObjectTest {
    @Test
    public void testCalcDate(){
        BackendDataObject data = new BackendDataObject();
        data.orderDate = LocalDateTime.of(2017, 8, 23, 0, 0);
        LocalDateTime d;
        d = data.getLocalDateTime(9, 23);
        assertEquals(2017, d.getYear());

        d = data.getLocalDateTime(1, 23);
        assertEquals(2018, d.getYear());
    
    }

}
