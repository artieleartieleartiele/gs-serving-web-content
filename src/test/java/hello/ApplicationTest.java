package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GreetingController.class)
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(content().string(containsString("Get your greeting")));
    }
    @Test
    public void greeting() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(content().string(containsString("Hello, World!")));
    }
    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "Greg"))
                .andExpect(content().string(containsString("Hello, Greg!")));
    }
}
