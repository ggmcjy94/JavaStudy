package you.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {

    public static void main(String[] args) {
        List<String> userIds = Arrays.asList("hello", "hi");
        boolean hello = checkUuidValidation("hello", userIds);
        System.out.println("hello = " + hello);
    }

    private static boolean checkUuidValidation(String workspaceId, List<String> userIds) {

        List<WorkspaceMember> workspaceMemberAll = getWorkspaceMembers(workspaceId);

        long count = workspaceMemberAll.stream().filter(w -> userIds.stream().anyMatch(u
                -> w.getUuid().equals(u))).count();


        System.out.println("count = " + count);

        return userIds.size() == count;
    }



    private static List<WorkspaceMember> getWorkspaceMembers(String workspaceId) {
        List<WorkspaceMember> workspaceMembers = new ArrayList<>();
        workspaceMembers.add(new WorkspaceMember(workspaceId));
        return workspaceMembers;
    }
}
