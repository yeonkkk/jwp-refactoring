package kitchenpos.mapper;

import java.util.List;
import java.util.stream.Collectors;
import kitchenpos.domain.MenuGroup;
import kitchenpos.dto.menu.MenuGroupCreateRequest;
import kitchenpos.dto.menu.MenuGroupResponse;

public class MenuGroupMapper {

    private MenuGroupMapper() {
    }

    public static MenuGroup toMenuGroup(final MenuGroupCreateRequest request) {
        return MenuGroup.from(request.getName());
    }

    public static MenuGroupResponse toMenuGroupResponse(final MenuGroup menuGroup) {
        return MenuGroupResponse.from(menuGroup);
    }

    public static List<MenuGroupResponse> toMenuGroupResponses(final List<MenuGroup> menuGroups) {
        return menuGroups.stream()
                .map(MenuGroupResponse::from)
                .collect(Collectors.toList());
    }
}
