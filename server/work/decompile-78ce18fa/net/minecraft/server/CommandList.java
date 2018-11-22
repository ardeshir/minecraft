package net.minecraft.server;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.List;
import java.util.function.Function;

public class CommandList {

    public static void a(com.mojang.brigadier.CommandDispatcher<CommandListenerWrapper> com_mojang_brigadier_commanddispatcher) {
        com_mojang_brigadier_commanddispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandDispatcher.a("list").executes((commandcontext) -> {
            return a((CommandListenerWrapper) commandcontext.getSource());
        })).then(CommandDispatcher.a("uuids").executes((commandcontext) -> {
            return b((CommandListenerWrapper) commandcontext.getSource());
        })));
    }

    private static int a(CommandListenerWrapper commandlistenerwrapper) {
        return a(commandlistenerwrapper, EntityHuman::getScoreboardDisplayName);
    }

    private static int b(CommandListenerWrapper commandlistenerwrapper) {
        return a(commandlistenerwrapper, EntityHuman::dC);
    }

    private static int a(CommandListenerWrapper commandlistenerwrapper, Function<EntityPlayer, IChatBaseComponent> function) {
        PlayerList playerlist = commandlistenerwrapper.getServer().getPlayerList();
        List list = playerlist.v();
        IChatBaseComponent ichatbasecomponent = ChatComponentUtils.b(list, function);

        commandlistenerwrapper.sendMessage(new ChatMessage("commands.list.players", new Object[] { Integer.valueOf(list.size()), Integer.valueOf(playerlist.getMaxPlayers()), ichatbasecomponent}), false);
        return list.size();
    }
}
