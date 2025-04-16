package benji.vegetables.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class VegetableFoodComponents {

    private static final int ZUCHINI_EFFECT_DURATION = VegetableItems.TICKS_PER_SECOND * VegetableItems.SECONDS_PER_MINUTE * 20;
    public static final FoodComponent ZUCHINI_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .alwaysEdible()
            .build();
    public static final ConsumableComponent ZUCHINI_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, ZUCHINI_EFFECT_DURATION), 1.0f))
            .build();
}
