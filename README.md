## :clipboard: Swing terminal
**Swing terminal** - that's a component for swing-applications, based on Jediterm, but with easy integration.
Thats looks like:

![alt text](https://github.com/Jankbyte/swing-terminal/blob/main/images/terminal.png)

Most count of code was take from [here], but that was "cleaned" and adapted for easy using.
## :hammer: Using in code
You can find base example [in this package]. You can just integrate that into JFrame:
```
JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Terminal terminal = new Terminal(100, 30);
frame.add(terminal, BorderLayout.CENTER);
frame.setVisible(true);
frame.setResizable(false);
frame.pack();
```
[here]: https://github.com/JetBrains/jediterm
[in this package]: https://github.com/Jankbyte/swing-terminal/tree/main/app/src/main/java/ru/jankbyte/terminal
