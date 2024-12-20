import sys
from functools import partial
from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import (
    QApplication,
    QMainWindow,
    QGridLayout,
    QLineEdit,
    QPushButton,
    QVBoxLayout,
    QWidget
)

ERROR_MSG = "ERROR"
WINDOW_SIZE = 250
DISPLAY_HEIGHT = 50
BUTTON_SIZE = 40


class PyCalcWindow(QMainWindow):
    def __init__(self, model):
        super().__init__()
        self.setWindowTitle("PyCalc")
        self.setFixedSize(WINDOW_SIZE, WINDOW_SIZE)
        self.generalLayout = QVBoxLayout()
        centralWidget = QWidget(self)
        centralWidget.setLayout(self.generalLayout)
        self.setCentralWidget(centralWidget)
        self._createDisplay()
        self._createButtons()
        self._evaluate = model
        self._connectSignalsAndSlots()

    def _createDisplay(self):
        self.display = QLineEdit()
        self.display.setFixedHeight(DISPLAY_HEIGHT)
        self.display.setAlignment(Qt.AlignmentFlag.AlignRight)
        self.display.setReadOnly(True)
        self.generalLayout.addWidget(self.display)

    def _createButtons(self):
        self.ButtonMap = {}
        buttonsLayout = QGridLayout()
        keyBoard = [
            ["7", "8", "9", "/", "C"],
            ["4", "5", "6", "*", ")"],
            ["1", "2", "3", "-", "("],
            ["0", "00", ".", "+", "="],
        ]
        for row, keys in enumerate(keyBoard):
            for col, key in enumerate(keys):
                self.ButtonMap[key] = QPushButton(key)
                self.ButtonMap[key].setFixedSize(BUTTON_SIZE, BUTTON_SIZE)
                buttonsLayout.addWidget(self.ButtonMap[key], row, col)
        self.generalLayout.addLayout(buttonsLayout)

    def setDisplayText(self, text):
        self.display.setText(text)
        self.display.setFocus()

    def displayText(self):
        return self.display.text()

    def clearDisplay(self):
        self.setDisplayText("")

    def _calculateResult(self):
        expression = self.displayText()
        result = self._evaluate(expression)
        self.setDisplayText(result)

    def _buildExpression(self, subExpression):
        if self.displayText() == ERROR_MSG:
            self.clearDisplay()
        expression = self.displayText() + subExpression
        self.setDisplayText(expression)

    def _connectSignalsAndSlots(self):
        for keySymbol, button in self.ButtonMap.items():
            if keySymbol not in {"=", "C"}:
                button.clicked.connect(partial(self._buildExpression, keySymbol))
        self.ButtonMap["="].clicked.connect(self._calculateResult)
        self.ButtonMap["C"].clicked.connect(self.clearDisplay)
        self.display.returnPressed.connect(self._calculateResult)


def evaluateExpression(expression):
    try:
        result = str(eval(expression, {}, {}))
    except Exception:
        result = ERROR_MSG
    return result


def main():
    pycalcApp = QApplication([])
    pycalcWindow = PyCalcWindow(model=evaluateExpression)
    pycalcWindow.show()
    sys.exit(pycalcApp.exec())


if __name__ == "__main__":
    main()