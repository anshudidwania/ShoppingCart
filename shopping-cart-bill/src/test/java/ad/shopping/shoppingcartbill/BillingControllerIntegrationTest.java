package ad.shopping.shoppingcartbill;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
@SpringBootTest
public class BillingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void computeBillAmount_NotFound() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "", "")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }
    @Test
    public void computeBillAmount_BadRequest() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "regular", "xvc")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest());
    }


    @Test
    public void computeBillAmount_regular_5000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "regular", 5000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(5000.00)));
    }
    @Test
    public void computeBillAmount_regular_10000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "regular", 10000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(9500.00)));
    }
    @Test
    public void computeBillAmount_regular_15000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "regular", 15000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(13500.00)));
    }
    @Test
    public void computeBillAmount_premium_4000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "premium", 4000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(3600.00)));
    }
    @Test
    public void computeBillAmount_premium_8000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "premium", 8000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(7000.00)));
    }
    @Test
    public void computeBillAmount_premium_12000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "premium", 12000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(10200.00)));
    }
    @Test
    public void computeBillAmount_premium_20000() throws Exception {
        this.mockMvc.perform(get("/bill/{customer-type}/{bill-amount}", "premium", 20000.00)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(15800.00)));
    }

}
