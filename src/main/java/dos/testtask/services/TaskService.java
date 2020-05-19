package dos.testtask.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import dos.testtask.models.Merlin;
import dos.testtask.models.Mission;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskService {

    public Merlin parseToObject(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());

        Merlin merlin = new Merlin();
        merlin.setCoreSerial(root.path("core_serial").asText());
        merlin.setBlock(root.path("block").asText());
        merlin.setStatus(root.path("status").asText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX").withZone(ZoneId.of("UTC"));
        merlin.setOriginalLaunch(LocalDateTime.parse(root.path("original_launch").asText(), formatter));
        merlin.setOriginalLaunchUnix(root.path("original_launch_unix").asLong());
        ObjectReader reader = objectMapper.readerFor(new TypeReference<List<Mission>>() {
        });
        List<Mission> list = reader.readValue(root.path("missions"));
        merlin.setMissions(list);
        merlin.setReuseCount(root.path("reuse_count").asLong());
        merlin.setRtlsAttempts(root.path("rtls_attempts").asLong());
        merlin.setRtlsLandings(root.path("rtls_landings").asLong());
        merlin.setAsdsAttempts(root.path("asds_attempts").asLong());
        merlin.setAsdsLandings(root.path("asds_landings").asLong());
        merlin.setWaterLanding(root.path("water_landing").asBoolean());
        merlin.setDetails(root.path("details").asText());

        return merlin;
    }

}
