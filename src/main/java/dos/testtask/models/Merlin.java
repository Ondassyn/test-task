package dos.testtask.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Merlin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String coreSerial;
    private String block;
    private String status;
    private LocalDateTime originalLaunch;
    private Long originalLaunchUnix;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Mission> missions;
    private Long reuseCount;
    private Long rtlsAttempts;
    private Long rtlsLandings;
    private Long asdsAttempts;
    private Long asdsLandings;
    private Boolean waterLanding;
    private String details;

    public Long getRtlsAttempts() {
        return rtlsAttempts;
    }

    @Override
    public String toString() {
        return "Merlin{" +
                "coreSerial='" + coreSerial + '\'' +
                ", block='" + block + '\'' +
                ", status='" + status + '\'' +
                ", originalLaunch=" + originalLaunch +
                ", originalLaunchUnix=" + originalLaunchUnix +
                ", missions=" + missions +
                ", reuseCount=" + reuseCount +
                ", rtlsAttempts=" + rtlsAttempts +
                ", rtlsLandings=" + rtlsLandings +
                ", asdsAttempts=" + asdsAttempts +
                ", asdsLandings=" + asdsLandings +
                ", waterLanding=" + waterLanding +
                ", details='" + details + '\'' +
                '}';
    }

    public void setRtlsAttempts(Long rtlsAttempts) {
        this.rtlsAttempts = rtlsAttempts;
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOriginalLaunch() {
        return originalLaunch;
    }

    public void setOriginalLaunch(LocalDateTime originalLaunch) {
        this.originalLaunch = originalLaunch;
    }

    public Long getOriginalLaunchUnix() {
        return originalLaunchUnix;
    }

    public void setOriginalLaunchUnix(Long originalLaunchUnix) {
        this.originalLaunchUnix = originalLaunchUnix;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public Long getReuseCount() {
        return reuseCount;
    }

    public void setReuseCount(Long reuseCount) {
        this.reuseCount = reuseCount;
    }

    public Long getRtlsLandings() {
        return rtlsLandings;
    }

    public void setRtlsLandings(Long rtlsLandings) {
        this.rtlsLandings = rtlsLandings;
    }

    public Long getAsdsAttempts() {
        return asdsAttempts;
    }

    public void setAsdsAttempts(Long asdsAttempts) {
        this.asdsAttempts = asdsAttempts;
    }

    public Long getAsdsLandings() {
        return asdsLandings;
    }

    public void setAsdsLandings(Long asdsLandings) {
        this.asdsLandings = asdsLandings;
    }

    public Boolean getWaterLanding() {
        return waterLanding;
    }

    public void setWaterLanding(Boolean waterLanding) {
        this.waterLanding = waterLanding;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
