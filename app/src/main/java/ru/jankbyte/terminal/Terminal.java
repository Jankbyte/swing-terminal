package ru.jankbyte.terminal;


import com.jediterm.pty.PtyProcessTtyConnector;
import com.jediterm.terminal.TextStyle;
import com.jediterm.terminal.TerminalColor;
import com.jediterm.terminal.TtyConnector;
import com.jediterm.terminal.ui.JediTermWidget;
import com.jediterm.terminal.ui.UIUtil;
import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;
import com.pty4j.PtyProcess;
import com.pty4j.PtyProcessBuilder;

import java.util.Map;
import java.util.HashMap;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.nio.charset.StandardCharsets;

public final class Terminal extends JPanel {
    private final DefaultSettingsProvider provider =
            new DefaultSettingsProvider() {
        @Override
        public Font getTerminalFont() {
            return new Font("Consolas", Font.PLAIN,
                (int) getTerminalFontSize());
        }

        @Override
        public float getTerminalFontSize() {
            return 12;
        }

        @Override
        public TextStyle getDefaultStyle() {
            return new TextStyle(TerminalColor.WHITE, TerminalColor.BLACK);
        }
    };

    public Terminal(int columns, int rows) {
        JediTermWidget widget = new JediTermWidget(columns, rows, provider);
        widget.setTtyConnector(createTtyConnector());
        widget.start();
        add(widget);
    }

    private TtyConnector createTtyConnector() {
        try {
            Map<String, String> envs = System.getenv();
            String[] command;
            if (UIUtil.isWindows) {
                command = new String[]{"cmd.exe"};
            } else {
                command = new String[]{"/bin/bash", "--login"};
                envs = new HashMap<>(System.getenv());
                envs.put("TERM", "xterm-256color");
            }
            PtyProcess process = new PtyProcessBuilder()
                .setCommand(command)
                .setEnvironment(envs).start();
            return new PtyProcessTtyConnector(process, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
