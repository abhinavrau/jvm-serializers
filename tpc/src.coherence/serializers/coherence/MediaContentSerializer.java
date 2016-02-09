package serializers.coherence;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofSerializer;
import com.tangosol.io.pof.PofWriter;
import data.media.Image;
import data.media.Media;
import data.media.MediaContent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Oracle Coherence POF serialization support for MediaContent class
 */


public class MediaContentSerializer  implements PofSerializer {




    @Override
    public void serialize(PofWriter pofWriter, Object o) throws IOException {
        MediaContent mediaContent = (MediaContent) o;
        pofWriter.writeObject(0, mediaContent.media);
        pofWriter.writeCollection(1, mediaContent.images);
        pofWriter.writeRemainder(null);
    }

    @Override
    public Object deserialize(PofReader pofReader) throws IOException {
        MediaContent mediaContent = new MediaContent();
        mediaContent.media = (Media)pofReader.readObject(0);
        mediaContent.images = (List<Image>) pofReader.readCollection(1,new ArrayList<Image>());
        return mediaContent;


    }
}
