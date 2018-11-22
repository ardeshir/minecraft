package net.minecraft.server;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import java.util.function.Function;
import java.util.function.Predicate;

public class CommandDifficulty {

    private static final DynamicCommandExceptionType a = new DynamicCommandExceptionType((object) -> {
        return new ChatMessage("commands.difficulty.failure", new Object[] { object});
    });

    public static void a(com.mojang.brigadier.CommandDispatcher<CommandListenerWrapper> com_mojang_brigadier_commanddispatcher) {
        LiteralArgumentBuilder literalargumentbuilder = CommandDispatcher.a("difficulty");
        EnumDifficulty[] aenumdifficulty = EnumDifficulty.values();
        int i = aenumdifficulty.length;

        for (int j = 0; j < i; ++j) {
            EnumDifficulty enumdifficulty = aenumdifficulty[j];

            literalargumentbuilder.then(CommandDispatcher.a(enumdifficulty.c()).executes((commandcontext) -> {
                return a((CommandListenerWrapper) commandcontext.getSource(), enumdifficulty);
            }));
        }

        com_mojang_brigadier_commanddispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) literalargumentbuilder.requires((commandlistenerwrapper) -> {
            return commandlistenerwrapper.hasPermission(2);
        })).executes((commandcontext) -> {
            EnumDifficulty enumdifficulty = ((CommandListenerWrapper) commandcontext.getSource()).getWorld().getDifficulty();

            ((CommandListenerWrapper) commandcontext.getSource()).sendMessage(new ChatMessage("commands.difficulty.query", new Object[] { enumdifficulty.b()}), false);
            return enumdifficulty.a();
        }));
    }

    public static int a(CommandListenerWrapper commandlistenerwrapper, EnumDifficulty enumdifficulty) throws CommandSyntaxException {
        MinecraftServer minecraftserver = commandlistenerwrapper.getServer();

        if (minecraftserver.getWorldServer(DimensionManager.OVERWORLD).getDifficulty() == enumdifficulty) {
            throw CommandDifficulty.a.create(enumdifficulty.c());
        } else {
            minecraftserver.a(enumdifficulty);
            commandlistenerwrapper.sendMessage(new ChatMessage("commands.difficulty.success", new Object[] { enumdifficulty.b()}), true);
            return 0;
        }
    }
}
