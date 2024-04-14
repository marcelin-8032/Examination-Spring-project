package com.examination.project.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MiscConverter {

    public static final Function<String, UUID> flipToUUID = UUID::fromString;

    public static final Function<List<String>, List<UUID>> flipToUUIDs = s -> s.stream().map(flipToUUID).collect(Collectors.toList());

    public static final Function<UUID, String> flipToString = UUID::toString;

    public static final Function<List<UUID>, List<String>> flipToStrings = u -> u.stream().map(flipToString).collect(Collectors.toList());
}
