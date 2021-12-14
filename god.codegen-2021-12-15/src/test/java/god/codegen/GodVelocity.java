package god.codegen;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

public class GodVelocity {

	@Test
	public void test() {
		System.out.println("test");

		Properties p = new Properties();
		p.setProperty("resource.loader.file.path", "src/test/resources");
		Velocity.init(p);

//		Velocity.init();

		VelocityContext context = new VelocityContext();

		context.put("name", new String("Velocity 테스트"));

		Template template = null;

//		try {
		template = Velocity.getTemplate("mytemplate.vm");
//		} catch (ResourceNotFoundException rnfe) {
//			// couldn't find the template
//		} catch (ParseErrorException pee) {
//			// syntax error: problem parsing the template
//		} catch (MethodInvocationException mie) {
//			// something invoked in the template
//			// threw an exception
//		} catch (Exception e) {
//		}

		StringWriter sw = new StringWriter();

		template.merge(context, sw);

		System.out.println(sw.toString());
	}

}
