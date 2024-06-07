import qrcode
from PIL import Image, ImageTk
import tkinter as tk
from tkinter import messagebox, filedialog


def generate_qr(till_number, amount=None):
    """
    Generate dynamic qr code based on provided till number and amount
    """
    # Qr code data format
    base_url = "qrpesa://pay?till={till_number}"  # To add the correct mpesa url scheme or url for the android app for testing
    if amount:
        base_url += f"&amount={amount}"
    qr_data = base_url.format(till_number=till_number, amount=amount)

    # Generate QR code
    qr = qrcode.QRCode(
        version=1,
        error_correction=qrcode.constants.ERROR_CORRECT_L,
        box_size=10,
        border=4,
    )

    qr.add_data(qr_data)
    qr.make(fit=True)

    # Generate an image from the QR code instance
    img = qr.make_image(fill='black', back_color='white')
    
    return img

def save_qr_image(img, filename):
    img.save(filename)

def on_generate_qr():
    till_number = entry_till_number.get()
    amount_input = entry_amount.get()

    if not till_number:
        messagebox.showerror("Input Error", "Please enter a till number")

        return
    
    try:
        amount = float(amount_input) if amount_input else None

    except ValueError:
        messagebox.showerror("Input Error", "Please enter a valid amount")
        return
    qr_image = generate_qr(till_number, amount)

    # Save image
    qr_image.save("qr.png")

    # Display the QR code in the GUI
    img = Image.open("qr.png")
    img = img.resize((250, 250), Image.LANCZOS)
    img = ImageTk.PhotoImage(img)
    label_qr_code.config(image=img)
    label_qr_code.image = img

def on_save_qr():
    filepath = filedialog.asksaveasfilename(defaultextension=".png", filetypes=[("PNG files", "*.png")])
    if filepath:
        try:
            till_number = entry_till_number.get()
            amount_input = entry_amount.get()
            amount = float(amount_input) if amount_input else None

            qr_image = generate_qr(till_number, amount)
            qr_image.save(filepath)
            messagebox.showinfo("Save QR Code", f"QR code saved successfully at {filepath}")
        except Exception as e:
            messagebox.showerror("Save Error", f"Error saving QR code: {e}")

# Set up the main application window
app = tk.Tk()
app.title("QrPesa")
app.geometry("400x500")

# Till number input
tk.Label(app, text="Till Number:").pack(pady=10)
entry_till_number = tk.Entry(app)
entry_till_number.pack()

# Amount input
tk.Label(app, text="Amount (optional):").pack(pady=10)
entry_amount = tk.Entry(app)
entry_amount.pack()

# Generate QR code button
button_generate = tk.Button(app, text="Generate QR Code", command=on_generate_qr)
button_generate.pack(pady=20)

# QR code display label
label_qr_code = tk.Label(app)
label_qr_code.pack(pady=20)

# Save QR code button
button_save = tk.Button(app, text="Save QR Code", command=on_save_qr)
button_save.pack(pady=20)

# Start the Tkinter event loop
app.mainloop()

def display_qr_image(img):
    img.show()

