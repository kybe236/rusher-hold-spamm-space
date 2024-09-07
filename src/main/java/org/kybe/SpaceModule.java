package org.kybe;

import org.rusherhack.client.api.events.client.EventUpdate;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.event.stage.Stage;
import org.rusherhack.core.event.subscribe.Subscribe;
import org.rusherhack.core.setting.EnumSetting;
import org.rusherhack.core.setting.NumberSetting;

public class SpaceModule extends ToggleableModule {

	//Mode enum
	public enum Mode {
		SPAMM,
		HOLD
	}

	private final EnumSetting<Mode> mode = new EnumSetting<>("Mode", Mode.HOLD);

	public SpaceModule() {
		super("Hold or spamm space", "Hold or spamm space", ModuleCategory.CLIENT);

		this.registerSettings(
				mode
		);
	}

	@Subscribe(stage = Stage.PRE)
	public void onTick(EventUpdate e) {
		if (mc.player == null) return;
		if (mode.getValue() == Mode.HOLD)
				mc.options.keyJump.setDown(true);
		else if (mode.getValue() == Mode.SPAMM)
			mc.options.keyJump.setDown(!mc.options.keyJump.isDown());
	}
	
	@Override
	public void onDisable() {
	}
}
