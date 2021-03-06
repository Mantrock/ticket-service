package emmert.frank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DocumentationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getSwaggerPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/swagger-ui.html#").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAPIDocs() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
