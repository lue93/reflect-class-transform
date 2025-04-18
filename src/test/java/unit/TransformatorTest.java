package unit;

import exampleclass.Contact;
import exampleclass.ContactDTO;
import br.com.ungaratto93.lib.refl.Transformer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;


public class TransformatorTest {

    Contact ct = new Contact("1","Foo", "foo@bar.com", "123456789");
    Contact ctNullVal = new Contact("1",null, "foo@bar.com", null);
    ContactDTO ctDto = new ContactDTO("name", "email", "phone");

    @Test
    public void shouldConstructObjectsForTest() {
        Assert.assertNotNull(ct);
        Assert.assertNotNull(ctNullVal);
        Assert.assertNotNull(ctDto);
    }

    @Test
    public void shouldTransformEntityToDto() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformer transformer = new Transformer();
        ContactDTO dto = transformer.transform(ct, ContactDTO.class);

        Assertions.assertEquals(ContactDTO.class.getName(), dto.getClass().getName());
    }

    @Test
    public void shouldTransformWithNullVal() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformer transformer = new Transformer();
        ContactDTO ctDtoNull = transformer.transform(ctNullVal, ContactDTO.class);

        Assert.assertNull(ctDtoNull.getName(), null);
        Assert.assertNull(ctDtoNull.getPhone(), null);
    }

}



