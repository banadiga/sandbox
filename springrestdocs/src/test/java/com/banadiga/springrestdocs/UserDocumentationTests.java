package com.banadiga.springrestdocs;

import com.banadiga.springrestdocs.user.User;
import com.banadiga.springrestdocs.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDocumentationTests {
  @Rule
  public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setUp() {
    userRepository.deleteAll();
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(this.restDocumentation))
        .build();
  }

  @Test
  public void listUsers() throws Exception {
    /* GIVEN */
    userRepository.save(asList(
        User.builder().name("Ihor Banadiga").login("ibanadiga").build(),
        User.builder().name("Ivan Ivanov").login("iianov").build()
        )
    );

    /* THEN */
    this.mockMvc.perform(get("/users"))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("list-users",
            pathParameters(
                parameterWithName("page").description("page").optional(),
                parameterWithName("size").description("size").optional(),
                parameterWithName("sort").description("sort").optional()),
            responseFields(
                subsectionWithPath("_embedded").description("embedded list"),
                subsectionWithPath("_embedded.users").description("embedded users"),
                subsectionWithPath("page").description("page"),
                subsectionWithPath("page.size").description("size"),
                subsectionWithPath("page.totalElements").description("totalElements"),
                subsectionWithPath("page.totalPages").description("totalPages"),
                subsectionWithPath("page.number").description("number"),
                subsectionWithPath("_links").description("links").attributes()),
//            responseFields(
//                fieldWithPath("_embedded").description("Embedded users list").type(JsonFieldType.OBJECT),
//                fieldWithPath("page").description("page info").type(JsonFieldType.OBJECT),
//                fieldWithPath("page.size").description("page size").type(JsonFieldType.NUMBER),
//                subsectionWithPath("_links").description("HAL links")),
            links(
                linkWithRel("self").description("Link to the self resource"),
                linkWithRel("next").description("Link to the next resource").optional(),
                linkWithRel("last").description("Link to the last resource").optional(),
                linkWithRel("first").description("Link to the first resource").optional(),
                linkWithRel("search").description("Link to the search resource").optional(),
                linkWithRel("profile").description("Link to the profile resource"))
        ));
  }

  @Test
  public void createUser() throws Exception {
    /* GIVEN */
    User user = User.builder().name("Ihor Banadiga").login("ibanadiga").build();

    /* THEN */
    this.mockMvc.perform(
        post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(user)))
        .andDo(print())
        .andExpect(status().isCreated())
        .andDo(document("create-user",
            requestFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING)),
            responseFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING),
                subsectionWithPath("_links").description("HAL links")),
            links(
                linkWithRel("self").description("Link to the self resource"),
                linkWithRel("user").description("Link to the user resource"))
            )
        );
  }

  @Test
  public void getUser() throws Exception {
    /* GIVEN */
    User user = User.builder().name("Ihor Banadiga").login("ibanadiga").build();
    userRepository.save(user);

    /* THEN */
    this.mockMvc.perform(get("/users/{id}", user.getId()))
        .andExpect(status().isOk())
        .andDo(print())
        .andDo(document("get-user",
            pathParameters(
                parameterWithName("id").description("The user id")),
            responseFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING),
                subsectionWithPath("_links").description("HAL links")),
            links(
                linkWithRel("self").description("Link to the self resource"),
                linkWithRel("user").description("Link to the user resource"))));
  }

  @Test
  public void updateUser() throws Exception {
    /* GIVEN */
    User user = User.builder().name("Igor Banadiga").login("ibanadiga").build();
    userRepository.save(user);

    User updatedUser = user.toBuilder().id(null).name("Ihor Banadiga").build();

    /* THEN */
    this.mockMvc.perform(
        put("/users/{id}", user.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(updatedUser)))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("update-user",
            pathParameters(
                parameterWithName("id").description("The user id")),
            requestFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING)),
            responseFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING),
                subsectionWithPath("_links").description("HAL links")),
            links(
                linkWithRel("self").description("Link to the self resource"),
                linkWithRel("user").description("Link to the user resource"))));
  }

  @Test
  public void patchUser() throws Exception {
    /* GIVEN */
    User user = User.builder().name("Igor Banadiga").login("ibanadiga").build();
    userRepository.save(user);

    User updatedUser = User.builder().name("Ihor Banadiga").build();

    /* THEN */
    this.mockMvc.perform(
        patch("/users/{id}", user.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(updatedUser)))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("patch-user",
            pathParameters(
                parameterWithName("id").description("The user id")),
            requestFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING).optional(),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING).optional()),
            responseFields(
                fieldWithPath("name").description("User name").type(JsonFieldType.STRING),
                fieldWithPath("login").description("User login").type(JsonFieldType.STRING),
                subsectionWithPath("_links").description("HAL links")),
            links(
                linkWithRel("self").description("Link to the self resource"),
                linkWithRel("user").description("Link to the user resource"))));
  }

  @Test
  public void deleteUser() throws Exception {
    /* GIVEN */
    User user = User.builder().name("Igor Banadiga").login("ibanadiga").build();
    userRepository.save(user);

    /* THEN */
    this.mockMvc.perform(
        delete("/users/{id}", user.getId())
            .param("name", "Ihor Banadiga")
            .param("login", "ibanadigaa"))
        .andDo(print())
        .andExpect(status().isNoContent())
        .andDo(document("delete-user",
            pathParameters(
                parameterWithName("id").description("The user id"))));
  }

  private String toJson(Object object) throws JsonProcessingException {
    return objectMapper.writeValueAsString(object);
  }
}
