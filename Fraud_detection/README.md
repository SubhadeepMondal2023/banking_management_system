# Fraud Detection Pipeline with Web App

This project implements a machine learning pipeline for detecting fraudulent financial transactions using a dataset of transaction records.
**The trained model achieves an impressive 94% accuracy (see notebook for details).**

## Project Structure

- `ananlysis_model.ipynb`: Jupyter notebook containing EDA, feature engineering, model training, and evaluation.
- `fraud_detection.py`: Streamlit web app for predicting fraud on new transactions.
- `AIML Dataset.csv`: Transaction dataset (ignored by git).
- `fraud_detection_pipeline.pkl`: Saved trained pipeline (ignored by git).
- `images/`: Contains project-related images.
- `README.md`: Project documentation.

## Dataset

The dataset used in this project is available on Kaggle:  
[Fraud Detection Dataset](https://www.kaggle.com/datasets/amanalisiddiqui/fraud-detection-dataset?resource=download)

## Getting Started

### Requirements

- Python 3.12+
- Packages: pandas, numpy, matplotlib, seaborn, scikit-learn, streamlit, joblib

Install dependencies:

```sh
pip install pandas numpy matplotlib seaborn scikit-learn streamlit joblib
```

### Usage

#### 1. Data Analysis & Model Training

Open and run [`ananlysis_model.ipynb`](ananlysis_model.ipynb) to:

- Load and explore the dataset
- Engineer features (`balanceDiffOrig`, `balanceDiffDest`)
- Train a logistic regression pipeline
- Save the trained model as `fraud_detection_pipeline.pkl`

#### 2. Web App Prediction

Run the Streamlit app:

```sh
streamlit run fraud_detection.py
```

Enter transaction details to get a fraud prediction using the trained model.

![Web App Screenshot](images/web-app.png)
## Features

- Exploratory Data Analysis (EDA)
- Feature engineering for transaction balances
- Machine learning pipeline with preprocessing and logistic regression
- Model evaluation (classification report, confusion matrix)
- Interactive web app for predictions

## Visualizations

Below are key charts from the analysis:

### Transaction Types Distribution
![Transaction Types](images/transaction_types.png)

### Fraud Rate by Type
![Fraud Rate by Type](images/fraud_by_type.png)

### Transaction Amount Distribution (Log Scaled)
![Amount Distribution](images/transaction_amount_distribution.png)

### Amount vs isFraud (Boxplot)
![Amount vs isFraud](images/amount_vs_isFraud.png)

### Frauds Over Time
![Frauds Over Time](images/frauds_over_time.png)

### Fraud Distribution in Transfer & Cash_Out
![Fraud Distribution](images/fraud_distribution_transfer_cashOut.png)

### Correlation Matrix
![Correlation Matrix](images/correlation_matrix_heatmap.png)

## Model Details

- **Preprocessing:** Standard scaling for numeric features, one-hot encoding for transaction type.
- **Model:** Logistic Regression (`class_weight='balanced'`, `max_iter=1000`)
- **Features Used:** `type`, `amount`, `oldbalanceOrg`, `newbalanceOrig`, `oldbalanceDest`, `newbalanceDest`

## Results

Model evaluation metrics and confusion matrix are available in the notebook output.  
See [`ananlysis_model.ipynb`](ananlysis_model.ipynb) for details.