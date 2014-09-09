package tzatziki.util;

import org.apache.commons.io.IOUtils;
import tzatziki.analysis.tag.TagDictionary;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class PropertiesLoader {
    public Properties loadFromUTF8Resource(String resourcePath) throws IOException {
        InputStream stream = PropertiesLoader.class.getResourceAsStream(resourcePath);
        try {
            return loadFromUTF8Stream(stream);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF8 not supported...", e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    public Properties loadFromUTF8Stream(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(stream, "UTF8"));
        return properties;
    }
}
