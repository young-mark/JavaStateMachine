# 住宅ローン計算 CLIツール（Java）

このプロジェクトは、Javaプログラミングの基礎を再確認する目的で作成された簡易的なコマンドラインアプリケーションです。状態ベースのフロー制御を利用して、住宅ローンの金利、元本、返済期間などを段階的に入力し、総支払額などを計算します。

## 主な技術・構成

- Java（標準ライブラリのみ使用）
- 状態パターン（State Pattern）によるフロー制御
- CLI（コマンドラインインターフェース）
- IntelliJ IDEA を使用して開発

## ディレクトリ構成

```
├── Main.java                         # アプリケーションのエントリーポイント
├── context/
│   └── Context.java                 # 現在の状態を保持するコンテキスト
├── machine/
│   └── MortgageStateMachine.java   # 状態マシンのロジック
├── mainbak.java                     # バックアップ用古いエントリポイント（.gitignore済み）
├── state/
│   ├── CalculateState.java         # 計算実行状態
│   ├── InterestRateState.java      # 金利入力状態
│   ├── PaymentTermsState.java      # 返済期間入力状態
│   ├── PrincipalState.java         # 元本入力状態
│   ├── State.java                  # 状態インターフェース
│   └── StateResult.java            # 各状態の出力結果
└── utils/
    └── ProcessInput.java           # 入力処理ユーティリティ
```

## 使用方法

```bash
# コンパイル
javac Main.java

# 実行
java Main
```

ユーザーは金利、元本、返済期間を順番に入力し、最終的な支払い情報を確認できます。

## 今後の改善アイデア（TODO）

- 入力バリデーションの強化
- 異常終了時のエラーメッセージ改善
- テストコードの追加（JUnitなど）
- GUIバージョン（Swing or JavaFX）

## ライセンス

MITライセンス（または好きなライセンスを記入）

