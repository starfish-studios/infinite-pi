package com.starfish_studios.infinite_pie.item;

import com.starfish_studios.infinite_pie.IPConfig;
import com.starfish_studios.infinite_pie.InfinitePie;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import static com.starfish_studios.infinite_pie.IPConfig.piHunger;
import static com.starfish_studios.infinite_pie.IPConfig.piSaturation;

public class InfinitePiItem extends Item {
    // region PI DIGITS
    private static final String PI_DIGITS =
            "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679" +
            "8214808651328230664709384460955058223172535940812848111745028410201938521105559644622948954930381964" +
            "4288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737" +
            "2458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160943" +
            "3057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129" +
            "9833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132" +
            "0005681271452635608277857713427577896091736371872146844090122495343014654958537105079227968925892354" +
            "2019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595" +
            "0244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473035" +
            "9825349042875546873115956286388235378759375195778185778053217122680661300192787661119590921642019893" +
            "8095257201065485863278865936153381827968230301952035301852968995773625994138912497217752834791315155" +
            "7485724245415065955082953311686172785588907509838175463746493931925506040092770167113900984882401285" +
            "8361603563770760104710181942955596198946767837449448255379774726847104047534646208046684259069491293" +
            "3136770289891521047521620569660240580381501135123382430035587640247496473263914199272604269922796782" +
            "3547816360093417216412199245863150302861829745557067498385054945885869269956909272107975093029553211" +
            "6534498720275596023648066549911981834797753566369807426542527862551818417574672890977727938000816470" +
            "6001614524919217321714772350141441973568548161361157352552133475741849468438523323907394143334547762" +
            "4168625189835694855620992121922218427255025425688767170494601653466804988622723279178608578438382796" +
            "7976814541009538837863609506800642251252051173929848960841284886269456042419652850222106611863067442" +
            "7862203919494504712371378696095636437191728746776465757396241389086583264599581339047802759009946576" +
            "4078951269468398352595709825822620552248940772671947826848260147699090264013639443745530506820349625" +
            "2451739936514314298091906592509372216964615157098583874105978859597729754989301617539284681382686838" +
            "8942774155991855925245953959431049972524680845987273644695848653836736222626099124608051243884390451" +
            "2441365497627807977156914359977001296160894416948685558484063534220722258284886481584560285060168427" +
            "3945226746767889525213852549954666727823986456566116354886230577456498035593634568174324112515076069" +
            "7945109659609402522887971089314566913686722874894056010150330861792868092087476091782493858900971490" +
            "9675985261365549781893129784821682998487226588048575640142704775511323796414515237462343645428584447" +
            "9526586782105114135473573952311342716610213596953623144295248493718711014576540359027993440374200731" +
            "0578539062198387447808478489683321445713868751943506430218453191048481005370614680674919278191119793" +
            "9952061419663428754440643745123718192179998391015919561814675142691239748940907186469423196156794520" +
            "8095146550225231603881930142093762137855956638937787083039069792077346722182562599661501421503068038" +
            "4477345492026054146659252014974428507325186660021324340881907104863317346496514539057962685610055081" +
            "0665879699816357473638405257145910289706414011097120628043903975951567715770042033786993670072305587" +
            "6317635942187312514712053292819182618612586732157919841484882916447060957527069572270917567116722910" +
            "9816909152801735067127485832228718352093539657251210835791513698820914442100675103346711031412671113" +
            "6990865851639831501970165151168517143765761835155650884909998985979823873455283316355076479185358932" +
            "2618548963213293308985706420467525907091548141654985946163718027098199430992448895757128289092323326" +
            "0972997120844335732654893823911932597463667305836041428138830320382490375898524374417029132765618093" +
            "7734403070746921120191302033038019762110110044929321516084244485963766983895228684783123552658213144" +
            "9576857262433441893039686426243410773226978028073189154411101044682325271620105265227211166039666557" +
            "3092547110557853763466820653098965269186205647693125705863566201855810072936065987648611179045334885" +
            "0346113657867532494441668039626579787718556084552965412665408530614344431858676975145661406800700237" +
            "8776591344017127494704205622305389945613140711270004078547326993908145466464588079727082668306342858" +
            "7856983052358089330657574067954571637752542021149557615814002501262285941302164715509792592309907965" +
            "4737612551765675135717857687565265697092932196586476948";
    // endregion

    public InfinitePiItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return IPConfig.piEatingSpeed;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        CompoundTag tag = itemStack.getOrCreateTag();

        int eatCount = tag.getInt("eatCount");
        eatCount++;
        tag.putInt("eatCount", eatCount);

        String currentPiLore = tag.getString("piLore");
        if (currentPiLore.isEmpty()) {
            currentPiLore = "3." + PI_DIGITS.charAt(0);
        } else {
            int digitsAppended = currentPiLore.length() - 2;
            if (digitsAppended < PI_DIGITS.length()) {
                char nextDigit = PI_DIGITS.charAt(digitsAppended);
                currentPiLore += nextDigit;
            }
        }
        tag.putString("piLore", currentPiLore);

        if (!level.isClientSide && livingEntity instanceof Player player) {
            player.getFoodData().eat(piHunger, piSaturation);
            if (IPConfig.piCooldown) {
                player.getCooldowns().addCooldown(this, 63);
            }
        }

        if (eatCount >= 314 && !level.isClientSide && livingEntity instanceof ServerPlayer serverPlayer) {
            Advancement advancement = Objects.requireNonNull(serverPlayer.getServer())
                    .getAdvancements()
                    .getAdvancement(new ResourceLocation(InfinitePie.MOD_ID, "husbandry/pie_times_pi"));
            if (advancement != null) {
                AdvancementProgress progress = serverPlayer.getAdvancements().getOrStartProgress(advancement);
                if (!progress.isDone()) {
                    for (String criterion : progress.getRemainingCriteria()) {
                        serverPlayer.getAdvancements().award(advancement, criterion);
                    }
                }
            }
        }

        return itemStack;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!world.isClientSide && stack.hasTag()) {
            CompoundTag tag = stack.getTag();
            assert tag != null;
            int eatCount = tag.getInt("eatCount");
            int digitsToShow = eatCount <= 0 ? 1 : Math.min(eatCount, PI_DIGITS.length());
            String expectedLore = "3." + PI_DIGITS.substring(0, digitsToShow);
            if (!expectedLore.equals(tag.getString("piLore"))) {
                tag.putString("piLore", expectedLore);
            }
        }
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            String piLore = tag.getString("piLore");
            if (piLore.isEmpty()) {
                piLore = "3." + PI_DIGITS.charAt(0);
            }
            int prefixLength = 2;
            String digits = piLore.substring(prefixLength);
            int lineLength = 50;

            tooltip.add(Component.literal("Eaten ")
                    .withStyle(ChatFormatting.GRAY)
                    .append(Component.literal(String.valueOf(tag.getInt("eatCount")))
                            .withStyle(ChatFormatting.YELLOW)
                            .append(Component.literal(" time(s)")
                                    .withStyle(ChatFormatting.GRAY))));

            int firstLineCount = Math.min(lineLength, digits.length());
            String firstLine = "3." + digits.substring(0, firstLineCount);
            tooltip.add(Component.literal(firstLine).withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC));

            for (int i = firstLineCount; i < digits.length(); i += lineLength) {
                int end = Math.min(i + lineLength, digits.length());
                String line = digits.substring(i, end);
                tooltip.add(Component.literal(line).withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC));
            }
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
