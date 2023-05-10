<?php $this->load->view("partial/header"); ?>

<?php
if(isset($error_message))
{
	echo "<div class='alert alert-dismissible alert-danger'>".$error_message."</div>";
	exit;
}
?>

<?php if(!empty($customer_email)): ?>
<script type="text/javascript">
$(document).ready(function()
{
	var send_email = function()
	{
		$.get('<?php echo site_url() . "sales/send_pdf/" . $sale_id_num; ?>',
			function(response)
			{
				$.notify(response.message, { type: response.success ? 'success' : 'danger'} );
			}, 'json'
		);
	};

	$("#show_email_button").click(send_email);

	<?php if(!empty($email_receipt)): ?>
		send_email();
	<?php endif; ?>
});
</script>
<?php endif; ?>

<?php $this->load->view('partial/print_receipt', array('print_after_sale'=>$print_after_sale, 'selected_printer'=>'invoice_printer')); ?>

<div class="print_hide" id="control_buttons" style="text-align:right">
	<a href="javascript:printdoc();"><div class="btn btn-info btn-sm", id="show_print_button"><?php echo '<span class="glyphicon glyphicon-print">&nbsp</span>' . $this->lang->line('common_print'); ?></div></a>
	<?php /* this line will allow to print and go back to sales automatically.... echo anchor("sales", '<span class="glyphicon glyphicon-print">&nbsp</span>' . $this->lang->line('common_print'), array('class'=>'btn btn-info btn-sm', 'id'=>'show_print_button', 'onclick'=>'window.print();')); */ ?>
	<?php if(isset($customer_email) && !empty($customer_email)): ?>
		<a href="javascript:void(0);"><div class="btn btn-info btn-sm", id="show_email_button"><?php echo '<span class="glyphicon glyphicon-envelope">&nbsp</span>' . $this->lang->line('sales_send_invoice'); ?></div></a>
	<?php endif; ?>
	<?php echo anchor("sales", '<span class="glyphicon glyphicon-shopping-cart">&nbsp</span>' . $this->lang->line('sales_register'), array('class'=>'btn btn-info btn-sm', 'id'=>'show_sales_button')); ?>
	<?php echo anchor("sales/manage", '<span class="glyphicon glyphicon-list-alt">&nbsp</span>' . $this->lang->line('sales_takings'), array('class'=>'btn btn-info btn-sm', 'id'=>'show_takings_button')); ?>
</div>

<div id="page-wrap">
	<div>COMPROBANTE DE COMPRA</div>
	<p>&nbsp;</p>
	<div id="block1">
		 <div>
			
			
			
		<div>&nbsp</div>  
		 <p Style="font-size: 120%;">
		 
		<?php echo $this->lang->line('sales_invoice_number');?>
		
		<?php echo $invoice_number; ?>
		</p>
		</div>
		<p Style="font-size: 120%;"><?php echo $this->lang->line('common_date'); ?>
		<?php echo $transaction_date; ?></p>
		
		 
		 
		 
			
		 

		<div id="logo" style="margin-left:20%">
			<?php
			if($this->Appconfig->get('company_logo') != '')
			{
			?>
				<img id="image" src="<?php echo base_url('uploads/' . $this->Appconfig->get('company_logo')); ?>" alt="company_logo" />
			<?php
			}
			?>
			<div>&nbsp</div>
			<?php
			if($this->Appconfig->get('receipt_show_company_name'))
			{
			?>
				<div id="company_name"><?php echo $this->config->item('company'); ?></div>
			<?php
			}
			?>
			
			
			
			
		</div>
		
		
		
	</div>

	<div id="block2">
		<div id="company-title">
		<P Style="font-size: 120%;">
		<?php echo nl2br($company_info) ?> 
</p>
		
		
		<br>
		
		<div>&nbsp</div> 
		<div>&nbsp</div>
		
		<P Style="font-size: 150%;">DATOS DEL CLIENTE<P>
		<P Style="font-size: 120%;">
		
		<?php
			if(isset($customer))
			{
			?>
				<?php echo nl2br($customer_info) ?>
			<?php
			}
			?>
			<br>
			</p>
			
			<P Style="font-size: 150%;">Detalle:<P>
			 
			
			
			<table style='font-family:"Arial"; font-size:130%'>
  <tr>
    <th>Cod.</th>
    <th>Detalle</th>
	<th>Cant.</th>
    <th>C.unit.</th>
	<th>Desc.</th>
	<th>P.U con Desc.</th>
	<th>Total.</th>
	 
  </tr>
  <tr>
			
			<?php
		foreach($cart as $line=>$item)
		{
			if($item['print_option'] == PRINT_YES)
			{
			?>
			
    <td> <?php 
	$codigo_producto = $item['item_number'];
	
	echo $codigo_producto; ?>
	
	<?php if($include_hsn): ?>
						 <?php echo $item['hsn_code']; ?> 
						 <?php endif; ?>
	</td>
    <td>
					 <?php 
					 
					 $detalle = ($item['is_serialized'] || $item['allow_alt_description']) && !empty($item['description']) ? $item['description'] : $item['name'] . ' ' . $item['attribute_values'];
					 
					 echo $detalle  ?>   </td>
					 <td><?php 
						$cantidad = to_quantity_decimals($item['quantity']);
					 echo $cantidad; ?> </td>
    <td> <?php 
	
	$precio_unitario = to_currency($item['price']);
	$precio_unitario2 = ($item['price']);
	
	echo $precio_unitario;  ?> </td>
	
	
	<td>  <?php echo ($item['discount_type']==FIXED)?to_currency($item['discount']):$item['discount'] . '%';?>  </td>
	
	
	
	
	<td>   
 
						 <?php 
						 
						 $precio_descuento = to_currency($item['discounted_total'] / $item['quantity']);
						 $precio_descuento2 = ($item['discounted_total'] / $item['quantity']);
						 echo  $precio_descuento ?> 	</td>
	
<td> <?php echo to_currency($item['discounted_total']); ?> 	</td>
				
					 
					
						 
					 
					 
					 
					 <?php
					 
					 
					 
					 
					 
					 ////////////////////////
					 
					 //CLAVE DE ACCESO
					 ///////////////////////
					 
					 
					 
							$orgDate = $transaction_date; 
							$newDate = date("dmY", strtotime($transaction_date));  
							
							
						 
							$claveaccpre = $newDate."01".$company_rucs."2001001".(str_pad($invoice_number,9,"0",STR_PAD_LEFT))."000000001";  
							
							
							 
							
							
							
							
							
							
							
							$digits = str_replace( array( '.', ',' ), array( ''.'' ), strrev($claveaccpre) );
							
							
							
						  if ( ! ctype_digit( $digits ) )
						  {
							echo "no";
						  }

						  $sum = 0;
						  $factor = 2;
						 
						  for( $i=0;$i<strlen( $digits ); $i++ )
						  {
							$sum += substr( $digits,$i,1 ) * $factor;
							if ( $factor == 7 )
							{
							  $factor = 2;
							}else{
							 $factor++;
						   }
						  }
						 
						  $dv = 11 - ($sum % 11);
						  if ( $dv < 10 )
						  {
							$mod = $dv;
						  }
						  if ( $dv == 10 )
						  {
							$mod = '1';
						  }
						  
						   if ( $dv == 11 )
						  {
							$mod = '0';
						  }
						  //echo "0";
							
						 
							 $clavedeacceso = $claveaccpre.$mod;
					 
											 
						   
						$servername = "localhost";
						$username = "root";
						$password = "";
						$dbname = "ospos";

						// Create connection
						$conn = new mysqli($servername, $username, $password, $dbname);
						// Check connection
						if ($conn->connect_error) {
							die("Connection failed: " . $conn->connect_error);
						}

						$sql = "SELECT clavedeacceso FROM ospos_electronic WHERE clavedeacceso = '$clavedeacceso' and cerrado = '0'";
						$result = $conn->query($sql);

						if ($result->num_rows > 0) {
							
						} else {
							 
							
							
							
							$conn2 = new mysqli($servername, $username, $password, $dbname);
							mysqli_set_charset($conn2, 'utf8'); 
						// Check connection
						if ($conn2->connect_error) {
							die("Connection failed: " . $conn2->connect_error);
						}



						$sql2 = "INSERT INTO `ospos_electronic` (`nfactura`, `clavedeacceso`, `ruc_cliente`, `cantidad`, `detalle`, `codigo_producto`, `precio_unitario`, `descuento`) VALUES ('$invoice_number', '$clavedeacceso', '$customer_ruc', '$cantidad', '$detalle', '$codigo_producto', '$precio_unitario2', '$precio_descuento2');";

						if ($conn2->query($sql2) === TRUE) {
							//echo "New record created successfully";
						} else {
							echo "Error: " . $sql2 . "<br>" . $conn->error;
						}

						$conn2->close();
							
							
							
							
						}
						$conn->close();
						 
						   
						 
						   
					 
					 ?>
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
				 
				 
				 
				 
				 
				   </tr>
   
 
				 
					  
					
						 
					
				 
			 
				<?php
				if($item['is_serialized'])
				{
				?>
					 
						 <?php echo $invoice_columns-1; ?> 
						 <?php echo $item['serialnumber']; ?> 
					 
				<?php
				}
			}
		}
		
		
		?>
			
			
			
			
			
			 
			  
			 
			
			
			
			
			
			
			
			
			
		</div>	</div>
		
		
		
		  
<tr>
	<table id="items" style='font-size: 130%; font-family:"Arial"'>
	 
		 

		<?php
		foreach($cart as $line=>$item)
		{
			if($item['print_option'] == PRINT_YES)
			{
			?>
				
				<?php
				if($item['is_serialized'])
				{
				?>
					 
						 
				<?php
				}
			}
		}
		?>

	 

		<tr>
			<td colspan="<?php echo $invoice_columns-3; ?>" class="blank-bottom"> </td>
			<td colspan="2" class="total-line"><?php echo $this->lang->line('sales_sub_total'); ?></td>
			<td class="total-value"><?php echo to_currency($subtotal); ?></td>
		</tr>

		<?php
		foreach($taxes as $tax_group_index=>$tax)
		{
		?>
			<tr>
				<td colspan="<?php echo $invoice_columns-3; ?>" class="blank"> </td>
				<td colspan="2" class="total-line">IVA <?php echo (float)$tax['tax_rate'] . '% ' . $tax['tax_group']; ?></td>
				<td class="total-value"><?php echo to_currency_tax($tax['sale_tax_amount']); ?></td>
			</tr>
		<?php
		}
		?>

		<tr>
			<td colspan="<?php echo $invoice_columns-3; ?>" class="blank"> </td>
			<td colspan="2" class="total-line"><?php echo $this->lang->line('sales_total'); ?></td>
			<td class="total-value"><?php echo to_currency($total); ?></td>
		</tr>

		<?php
		$only_sale_check = FALSE;
		$show_giftcard_remainder = FALSE;
		foreach($payments as $payment_id=>$payment)
		{
			$only_sale_check |= $payment['payment_type'] == $this->lang->line('sales_check');
			$splitpayment = explode(':', $payment['payment_type']);
			$show_giftcard_remainder |= $splitpayment[0] == $this->lang->line('sales_giftcard');
		?>
			<tr>
				<td colspan="<?php echo $invoice_columns-3; ?>" class="blank"> </td>
				<td colspan="2" class="total-line"><?php echo $splitpayment[0]; ?></td>
				<td class="total-value"><textarea rows="5" cols="6" id="paid"><?php echo to_currency( $payment['payment_amount'] * -1 ); ?></td>
			</tr>
		<?php
		}

		if(isset($cur_giftcard_value) && $show_giftcard_remainder)
		{
		?>
			<tr>
				<td colspan="<?php echo $invoice_columns-3; ?>" class="blank"> </td>
				<td colspan="2" class="total-line"><?php echo $this->lang->line('sales_giftcard_balance'); ?></td>
				<td class="total-value"><textarea rows="5" cols="6" id="giftcard"><?php echo to_currency($cur_giftcard_value); ?></td>
			</tr>
			<?php
		}

		if(!empty($payments))
		{
		?>
		<tr>
			<td colspan="<?php echo $invoice_columns-3; ?>" class="blank"> </td>
			<td colspan="2" class="total-line"> <?php echo $this->lang->line($amount_change >= 0 ? ($only_sale_check ? 'sales_check_balance' : 'sales_change_due') : 'sales_amount_due') ; ?></td>
			<td class="total-value"><textarea rows="5" cols="6" id="change"><?php echo to_currency($amount_change); ?></td>
		</tr>
		<?php
		}
		?>

		
		</table>
<p>&nbsp;</p>
 
	 <p >CLAVE DE ACCESO</P>
	 
	 <p style='font-family:"Arial"; font-size:150%'>
	<?php 
	
	//echo $transaction_date; 
	
 echo $clavedeacceso;
	
	 
   
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
	
	
	?></p>

	
</div>


 <?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "ospos";







$conn3 = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn3->connect_error) {
    die("Connection failed: " . $conn3->connect_error);
}

$sql3 = "SELECT clave_acceso FROM ospos_sales WHERE invoice_number = '$invoice_number'";
$result3 = $conn3->query($sql3);

if ($result3->num_rows > 0) {
    // output data of each row
    while($row = $result3->fetch_assoc()) {
       $a = $row["clave_acceso"];
	   
	   if($a==$clavedeacceso){
		   
	   }else{
	   
	   
	  
  





$conn4 = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn4->connect_error) {
    die("Connection failed: " . $conn4->connect_error);
}

$sql4 = "UPDATE `ospos_sales` SET `clave_acceso`='$clavedeacceso' WHERE  `invoice_number`='$invoice_number';";

if ($conn4->query($sql4) === TRUE) {
  //  echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn4->error;
}

$conn4->close();

	    



  //echo 'is empty';
}
    }
}  
$conn3->close();






$conn8 = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn8->connect_error) {
    die("Connection failed: " . $conn8->connect_error);
}

$sql8 = "UPDATE `ospos_electronic` SET `cerrado`='0' WHERE  `cerrado`='1'";

if ($conn8->query($sql8) === TRUE) {
   
} else {
    echo "Error updating record: " . $conn8->error;
}

$conn8->close();










?> 

<script type="text/javascript">
$(window).on("load", function()
{
	// install firefox addon in order to use this plugin
	if(window.jsPrintSetup)
	{
		<?php if(!$this->Appconfig->get('print_header'))
		{
		?>
			// set page header
			jsPrintSetup.setOption('headerStrLeft', '');
			jsPrintSetup.setOption('headerStrCenter', '');
			jsPrintSetup.setOption('headerStrRight', '');
		<?php
		}

		if(!$this->Appconfig->get('print_footer'))
		{
		?>
			// set empty page footer
			jsPrintSetup.setOption('footerStrLeft', '');
			jsPrintSetup.setOption('footerStrCenter', '');
			jsPrintSetup.setOption('footerStrRight', '');
		<?php
		}
		?>
	}
});
</script>

<?php $this->load->view("partial/footer"); ?>
