package exam;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class test2 {

    private boolean checkUuidValidation(String workspaceId, List<String> userIds) {
        List<WorkspaceMember> workspaceMemberAll = getWorkspaceMembers(workspaceId);
        return userIds.size() == workspaceMemberAll.stream().filter(w -> userIds.stream().anyMatch(u
                -> w.getUuid().equals(u))).count();
    }



    private List<WorkspaceMember> getWorkspaceMembers(String workspaceId) {
        return null;
    }
}
