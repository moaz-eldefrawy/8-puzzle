import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface Traversal {
    public Integer pathCost();

    public Integer nodesExpanded();

    public Integer searchDepth();

    /**
     * @return execution time in ms.
     */
    public Long runningTime();

}
